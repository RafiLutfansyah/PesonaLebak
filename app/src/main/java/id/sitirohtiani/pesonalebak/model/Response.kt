package id.sitirohtiani.pesonalebak.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("response") @Expose val response: String)