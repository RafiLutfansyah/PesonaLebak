package id.sitirohtiani.pesonalebak.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Review(
        @SerializedName("id") @Expose val id: Int,
        @SerializedName("id_wisata") @Expose val id_wisata: String,
        @SerializedName("review") @Expose val review: String,
        @SerializedName("email") @Expose val email: String,
        @SerializedName("nama") @Expose val nama: String,
        @SerializedName("url_foto") @Expose val url_foto: String)