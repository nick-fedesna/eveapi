package biz.apollogames.eve.api;

import java.net.Proxy;
import java.util.Date;

import biz.apollogames.eve.api.account.*;
import biz.apollogames.eve.api.character.*;
import biz.apollogames.eve.api.eve.TypeName;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.transform.RegistryMatcher;
import retrofit.*;
import retrofit.android.AndroidLog;
import retrofit.converter.SimpleXMLConverter;
import timber.log.Timber;

public class ApiHelper {

    private Persister      mXmlSerializer;
    private RestAdapter    mRestAdapter;
    private EveApiRetrofit mEveApi;

    private String mBaseUrlLive;
    private String mBaseUrlTest;
    private boolean mUseTestApi = false;

    private RestAdapter.LogLevel mLogLevel = RestAdapter.LogLevel.NONE;

    protected long   keyID;
    protected String vCode;

    public ApiHelper() {}

    public ApiHelper(long keyID, String vCode) {
        this.keyID = keyID;
        this.vCode = vCode;

        setProxy(Proxy.NO_PROXY);

        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, BaseResponse.DATE_TRANSFORMER);
        mXmlSerializer = new Persister(matcher, new Format(2));
    }

    public void setCredentials(long keyID, String vCode) {
        this.keyID = keyID;
        this.vCode = vCode;
    }

    protected EveApiRetrofit api() {
        if (mEveApi == null) {
            mRestAdapter = getRestAdapter();
            mEveApi = mRestAdapter.create(EveApiRetrofit.class);
        }
        return mEveApi;
    }

    protected RestAdapter getRestAdapter() {
        return new RestAdapter.Builder()
                .setConverter(new SimpleXMLConverter(mXmlSerializer))
                .setLog(new AndroidLog(getClass().getSimpleName()))
                .setLogLevel(mLogLevel)
                .setErrorHandler(getErrorHandler())
                .setEndpoint(getBaseUrl())
                .build();
    }

    protected ErrorHandler getErrorHandler() {
        return new ErrorHandler() {
            @Override
            public Throwable handleError(RetrofitError retrofitError) {
                Object body = retrofitError.getBody();
                if (body instanceof BaseResponse) {
                    BaseResponse.Error e = ((BaseResponse) body).error;
                    Timber.e("EVE API ERROR: %s (%d)", e.message, e.code);
                }
                return retrofitError;
            }
        };
    }

    public String getBaseUrl() {
        return mUseTestApi ? mBaseUrlTest : mBaseUrlLive;
    }

    public void setLogLevel(RestAdapter.LogLevel level) {
        mLogLevel = level;

        if (mRestAdapter != null) {
            mRestAdapter.setLogLevel(mLogLevel);
        }
    }

    public void setProxy(Proxy proxy) {
        String protocol = proxy == Proxy.NO_PROXY ? "https://" : "http://";
        mBaseUrlLive = protocol + "api.eveonline.com"; // Tranquility
        mBaseUrlTest = protocol + "api.testeveonline.com"; // Singularity
        mEveApi = null;
    }

    public void setUseTestApi(boolean useTest) {
        mUseTestApi = useTest;
        mEveApi = null;
    }

    public TypeName getTypeNames(Long... ids) {
        return api().getTypeNames(ids);
    }

    public AccountStatus getAccountStatus() {
        return api().getAccountStatus(keyID, vCode);
    }

    public Characters getCharacters() {
        return api().getCharacters(keyID, vCode);
    }

    public KeyInfo getKeyInfo() {
        return api().getKeyInfo(keyID, vCode);
    }

}
