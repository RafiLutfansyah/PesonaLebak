package id.sitirohtiani.pesonalebak.views.objekwisata

import android.widget.Adapter
import id.sitirohtiani.pesonalebak.adapter.ListWisata
import id.sitirohtiani.pesonalebak.base.View

/**
 * Created by Rafi Lutfansyah on 12/02/2018.
 */
interface ObjekWisataView : View {
    fun onSuccess(adapter: ListWisata)
}