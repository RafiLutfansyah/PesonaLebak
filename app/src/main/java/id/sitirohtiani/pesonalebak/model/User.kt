package id.sitirohtiani.pesonalebak.model

import android.net.Uri
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("email") @Expose val email: String,
        @SerializedName("nama") @Expose val nama: String,
        @SerializedName("url_foto") @Expose val urlFoto: String)