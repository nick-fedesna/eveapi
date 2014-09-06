package biz.apollogames.eve.api;

import biz.apollogames.eve.api.account.*;
import biz.apollogames.eve.api.character.*;
import biz.apollogames.eve.api.eve.TypeName;
import retrofit.Callback;
import retrofit.http.*;

public interface EveApiRetrofit {

    static final String KEYID  = "keyId";
    static final String VCODE  = "vCode";
    static final String CHARID = "characterID";

    @POST(TypeName.PATH)
    @FormUrlEncoded
    TypeName getTypeNames(@Field("ids") Long... ids);

    // ACCOUNT
    @POST(KeyInfo.PATH)
    @FormUrlEncoded
    KeyInfo getKeyInfo(@Field(KEYID) long keyID,
                       @Field(VCODE) String vCode);

    @POST(AccountStatus.PATH) @FormUrlEncoded
    AccountStatus getAccountStatus(@Field(KEYID) long keyID,
                                   @Field(VCODE) String vCode);

    @POST(Characters.PATH) @FormUrlEncoded
    Characters getCharacters(@Field(KEYID) long keyID,
                             @Field(VCODE) String vCode);

    // CHARACTER
    @POST(AccountBalance.PATH) @FormUrlEncoded
    AccountBalance getAccountBalance(@Field(KEYID) long keyID,
                                     @Field(VCODE) String vCode,
                                     @Field(CHARID) long characterID);

    @POST(AccountBalance.PATH) @FormUrlEncoded
    void getAccountBalance(@Field(KEYID) long keyID,
                           @Field(VCODE) String vCode,
                           @Field(CHARID) long characterID,
                           Callback<AccountBalance> callback);

    @POST(AssetList.PATH) @FormUrlEncoded
    AssetList getAssetList(@Field(KEYID) long keyID,
                           @Field(VCODE) String vCode,
                           @Field(CHARID) long characterID);


    @POST(CharacterSheet.PATH) @FormUrlEncoded
    CharacterSheet getCharacterSheet(@Field(KEYID) long keyID,
                                     @Field(VCODE) String vCode,
                                     @Field(CHARID) long characterID);


    @POST(Contracts.PATH) @FormUrlEncoded
    Contracts getContracts(@Field(KEYID) long keyID,
                           @Field(VCODE) String vCode,
                           @Field(CHARID) long characterID);


    @POST(Contracts.Items.PATH) @FormUrlEncoded
    Contracts.Items getContractItems(@Field(KEYID) long keyID,
                                     @Field(VCODE) String vCode,
                                     @Field(CHARID) long characterID,
                                     @Field("contractID") long contractID);

    @POST(IndustryJobs.CURRENT) @FormUrlEncoded
    IndustryJobs getIndustryJobs(@Field(KEYID) long keyID,
                                 @Field(VCODE) String vCode,
                                 @Field(CHARID) long characterID);

    @POST(KillLog.PATH) @FormUrlEncoded
    KillLog getKillLog(@Field(KEYID) long keyID,
                       @Field(VCODE) String vCode,
                       @Field(CHARID) long characterID,
                       @Field("fromID") long fromID,
                       @Field("rowCount") long rowCount);

    @POST(KillLog.PATH) @FormUrlEncoded
    KillLog getKillLog(@Field(KEYID) long keyID,
                       @Field(VCODE) String vCode,
                       @Field(CHARID) long characterID,
                       @Field("rowCount") long rowCount);

    @POST(Mail.MESSAGES) @FormUrlEncoded
    Mail getMail(@Field(KEYID) long keyID,
                 @Field(VCODE) String vCode,
                 @Field(CHARID) long characterID);

    @POST(Mail.BODIES) @FormUrlEncoded
    Mail.Bodies getMailBodies(@Field(KEYID) long keyID,
                              @Field(VCODE) String vCode,
                              @Field(CHARID) long characterID,
                              @Field("ids") Long... ids);


    @POST(Planetary.COLONIES) @FormUrlEncoded
    Planetary getPlanetary(@Field(KEYID) long keyID,
                           @Field(VCODE) String vCode,
                           @Field(CHARID) long characterID);

    @POST(Planetary.PINS) @FormUrlEncoded
    Planetary.Pins getPlanetaryPins(@Field(KEYID) long keyID,
                                    @Field(VCODE) String vCode,
                                    @Field(CHARID) long characterID,
                                    @Field("planetID") long planetID);

    @POST(Planetary.ROUTES) @FormUrlEncoded
    Planetary.Routes getPlanetaryRoutes(@Field(KEYID) long keyID,
                                        @Field(VCODE) String vCode,
                                        @Field(CHARID) long characterID,
                                        @Field("planetID") long planetID);

    @POST(Planetary.LINKS) @FormUrlEncoded
    Planetary.Links getPlanetaryLinks(@Field(KEYID) long keyID,
                                      @Field(VCODE) String vCode,
                                      @Field(CHARID) long characterID,
                                      @Field("planetID") long planetID);

    @POST(SkillQueue.PATH) @FormUrlEncoded
    SkillQueue getSkillQueue(@Field(KEYID) long keyID,
                             @Field(VCODE) String vCode,
                             @Field(CHARID) long characterID);

    @POST(SkillQueue.TRAINING) @FormUrlEncoded
    SkillQueue.Training getSkillInTraining(@Field(KEYID) long keyID,
                                           @Field(VCODE) String vCode,
                                           @Field(CHARID) long characterID);



}
