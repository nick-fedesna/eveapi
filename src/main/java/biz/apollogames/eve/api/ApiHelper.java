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

    private String mBaseUrl;
    private String mBaseUrlLive;
    private String mBaseUrlTest;
    private boolean mUseTestApi = false;

    private RestAdapter.LogLevel mLogLevel = RestAdapter.LogLevel.NONE;

    private long   keyID;
    private String vCode;

    public ApiHelper(long keyID, String vCode) {
        this.keyID = keyID;
        this.vCode = vCode;

        setProxy(Proxy.NO_PROXY);

        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, BaseResponse.DATE_TRANSFORMER);
        mXmlSerializer = new Persister(matcher, new Format(2));
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

    public AccountBalance getAccountBalance(long characterID) {
        return api().getAccountBalance(keyID, vCode, characterID);
    }

    public AssetList getAssetList(long characterID) {
        return api().getAssetList(keyID, vCode, characterID);
    }

    public CharacterSheet getCharacterSheet(long characterID) {
        return api().getCharacterSheet(keyID, vCode, characterID);
    }

    public Contracts getContracts(long characterID) {
        return api().getContracts(keyID, vCode, characterID);
    }

    public Contracts.Items getContractItems(long characterID, long contractID) {
        return api().getContractItems(keyID, vCode, characterID, contractID);
    }

    public IndustryJobs getIndustryJobs(long characterID) {
        return api().getIndustryJobs(keyID, vCode, characterID);
    }

    public KillLog getKillLog(long characterID) {
        return api().getKillLog(keyID, vCode, characterID, 10);
    }

    public Mail getMail(long characterID) {
        return api().getMail(keyID, vCode, characterID);
    }

    public Mail.Bodies getMailBodies(long characterID, Long... ids) {
        return api().getMailBodies(keyID, vCode, characterID, ids);
    }

    public Planetary getPlanetary(long characterID) {
        return api().getPlanetary(keyID, vCode, characterID);
    }

    public Planetary.Pins getPlanetaryPins(long characterID, long planetID) {
        return api().getPlanetaryPins(keyID, vCode, characterID, planetID);
    }

    public Planetary.Routes getPlanetaryRoutes(long characterID, long planetID) {
        return api().getPlanetaryRoutes(keyID, vCode, characterID, planetID);
    }

    public Planetary.Links getPlanetaryLinks(long characterID, long planetID) {
        return api().getPlanetaryLinks(keyID, vCode, characterID, planetID);
    }

    public SkillQueue getSkillQueue(long characterID) {
        return api().getSkillQueue(keyID, vCode, characterID);
    }

    public SkillQueue.Training getSkillInTraining(long characterID) {
        return api().getSkillInTraining(keyID, vCode, characterID);
    }

}
