package id.sitirohtiani.pesonalebak.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Wisata(@SerializedName("id") @Expose val id: Int,
                  @SerializedName("kategori_destinasi") @Expose val kDestinasi: String,
                  @SerializedName("kategori_wisata") @Expose val kWisata: String,
                  @SerializedName("nama") @Expose val nama: String,
                  @SerializedName("keterangan") @Expose val keterangan: String,
                  @SerializedName("url_foto") @Expose val urlFoto: String,
                  @SerializedName("alamat") @Expose val alamat: String,
                  @SerializedName("koordinat") @Expose val koordinat: String,
                  @SerializedName("rating") @Expose val rating: Int)