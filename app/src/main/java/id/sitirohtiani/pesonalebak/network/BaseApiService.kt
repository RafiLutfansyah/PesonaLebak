package id.sitirohtiani.pesonalebak.network

import android.net.Uri
import id.sitirohtiani.pesonalebak.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */

interface BaseApiService {
    @GET("User")
    fun getUser(@Query("email") email: String): Call<User>

    @POST("User")
    @FormUrlEncoded
    fun postUser(@Field("email") email: String,
                 @Field("nama") nama: String,
                 @Field("url_foto") url_foto: Uri): Call<User>

    @GET("MainCarousel")
    fun getMainCorousel(): Call<List<Wisata>>

    @GET("Wisata")
    fun getListWisata(@Query("kategori_destinasi") key: String,
                      @Query("kategori_wisata") wisata: String): Call<List<Wisata>>

    @GET("Review")
    fun getListReview(@Query("id_wisata") idWisata: Int): Call<List<Review>>

    @POST("Review")
    @FormUrlEncoded
    fun postReview(@Field("id_wisata") idWisata: Int,
                   @Field("email") email: String,
                   @Field("review") review: String): Call<List<Review>>

    @GET("Rating")
    fun getRating(@Query("switch") switch: String,
                  @Query("id_wisata") idWisata: Int): Call<Int>

    @GET("Rating")
    fun checkRating(@Query("switch") switch: String,
                    @Query("id_wisata") idWisata: Int,
                    @Query("email") email: String): Call<List<Rating>>

    @POST("Rating")
    @FormUrlEncoded
    fun setRating(@Field("id_wisata") idWisata: Int,
                  @Field("email") email: String,
                  @Field("rating") rating: Float): Call<List<Rating>>
}