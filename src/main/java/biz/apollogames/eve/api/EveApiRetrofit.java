package biz.apollogames.eve.api;

import biz.apollogames.eve.api.account.*;
import biz.apollogames.eve.api.character.*;
import biz.apollogames.eve.api.eve.TypeName;
import retrofit.Callback;
import retrofit.http.*;

public interface EveApiRetrofit {

    @POST(TypeName.PATH) @FormUrlEncoded
    TypeName getTypeNames(@Field("ids") Long... ids);

    // ACCOUNT
    @POST(KeyInfo.PATH) @FormUrlEncoded
    KeyInfo getKeyInfo(@Field("keyID") long keyID,
                       @Field("vCode") String vCode);

    @POST(AccountStatus.PATH) @FormUrlEncoded
    AccountStatus getAccountStatus(@Field("keyID") long keyID,
                                   @Field("vCode") String vCode);

    @POST(Characters.PATH) @FormUrlEncoded
    Characters getCharacters(@Field("keyID") long keyID,
                             @Field("vCode") String vCode);

    // CHARACTER
    @POST(AccountBalance.PATH) @FormUrlEncoded
    AccountBalance getAccountBalance(@Field("keyID") long keyID,
                                     @Field("vCode") String vCode,
                                     @Field("characterID") long characterID);

    @POST(AccountBalance.PATH) @FormUrlEncoded
    void getAccountBalance(@Field("keyID") long keyID,
                           @Field("vCode") String vCode,
                           @Field("characterID") long characterID,
                           Callback<AccountBalance> callback);

    @POST(AssetList.PATH) @FormUrlEncoded
    AssetList getAssetList(@Field("keyID") long keyID,
                           @Field("vCode") String vCode,
                           @Field("characterID") long characterID);


    @POST(CharacterSheet.PATH) @FormUrlEncoded
    CharacterSheet getCharacterSheet(@Field("keyID") long keyID,
                                     @Field("vCode") String vCode,
                                     @Field("characterID") long characterID);


    @POST(Contracts.PATH) @FormUrlEncoded
    Contracts getContracts(@Field("keyID") long keyID,
                           @Field("vCode") String vCode,
                           @Field("characterID") long characterID);


    @POST(Contracts.Items.PATH) @FormUrlEncoded
    Contracts.Items getContractItems(@Field("keyID") long keyID,
                                     @Field("vCode") String vCode,
                                     @Field("characterID") long characterID,
                                     @Field("contractID") long contractID);

    @POST(IndustryJobs.CURRENT) @FormUrlEncoded
    IndustryJobs getIndustryJobs(@Field("keyID") long keyID,
                                 @Field("vCode") String vCode,
                                 @Field("characterID") long characterID);

    @POST(KillLog.PATH) @FormUrlEncoded
    KillLog getKillLog(@Field("keyID") long keyID,
                       @Field("vCode") String vCode,
                       @Field("characterID") long characterID,
                       @Field("fromID") long fromID,
                       @Field("rowCount") long rowCount);

    @POST(KillLog.PATH) @FormUrlEncoded
    KillLog getKillLog(@Field("keyID") long keyID,
                       @Field("vCode") String vCode,
                       @Field("characterID") long characterID,
                       @Field("rowCount") long rowCount);

    @POST(Mail.MESSAGES) @FormUrlEncoded
    Mail getMail(@Field("keyID") long keyID,
                 @Field("vCode") String vCode,
                 @Field("characterID") long characterID);

    @POST(Mail.BODIES) @FormUrlEncoded
    Mail.Bodies getMailBodies(@Field("keyID") long keyID,
                              @Field("vCode") String vCode,
                              @Field("characterID") long characterID,
                              @Field("ids") Long... ids);


    @POST(Planetary.COLONIES) @FormUrlEncoded
    Planetary getPlanetary(@Field("keyID") long keyID,
                           @Field("vCode") String vCode,
                           @Field("characterID") long characterID);

    @POST(Planetary.PINS) @FormUrlEncoded
    Planetary.Pins getPlanetaryPins(@Field("keyID") long keyID,
                                    @Field("vCode") String vCode,
                                    @Field("characterID") long characterID,
                                    @Field("planetID") long planetID);

    @POST(Planetary.ROUTES) @FormUrlEncoded
    Planetary.Routes getPlanetaryRoutes(@Field("keyID") long keyID,
                                        @Field("vCode") String vCode,
                                        @Field("characterID") long characterID,
                                        @Field("planetID") long planetID);

    @POST(Planetary.LINKS) @FormUrlEncoded
    Planetary.Links getPlanetaryLinks(@Field("keyID") long keyID,
                                      @Field("vCode") String vCode,
                                      @Field("characterID") long characterID,
                                      @Field("planetID") long planetID);

    @POST(SkillQueue.PATH) @FormUrlEncoded
    SkillQueue getSkillQueue(@Field("keyID") long keyID,
                             @Field("vCode") String vCode,
                             @Field("characterID") long characterID);

    @POST(SkillQueue.TRAINING) @FormUrlEncoded
    SkillQueue.Training getSkillInTraining(@Field("keyID") long keyID,
                                           @Field("vCode") String vCode,
                                           @Field("characterID") long characterID);



}
