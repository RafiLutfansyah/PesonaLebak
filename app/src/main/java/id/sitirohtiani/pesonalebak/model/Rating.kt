package id.sitirohtiani.pesonalebak.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(
        @SerializedName("id") @Expose val id: Int,
        @SerializedName("id_wisata") @Expose val id_wisata: String,
        @SerializedName("email") @Expose val email: String,
        @SerializedName("rating") @Expose val rating: String)