package `fun`.kitsunebi.kitsunebi4android.common

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{path}")
    fun getUserInfo(@Path("path") string: String): Call<UserInfoEntity>

//    @GET("users/HexlDL/followers")
//    fun getFollowers():Observable<List<FollowersEntity>>
}