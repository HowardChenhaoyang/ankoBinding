package binding.anko.chy.com.library.dataBinding

import android.view.View
import binding.anko.chy.com.library.model.AnkoBindingModel

interface AnkoDataBinding<V : View, M : AnkoBindingModel> {
    fun bind(v: V, m: M)
    fun twoWayBind(v: V, m: M)
}