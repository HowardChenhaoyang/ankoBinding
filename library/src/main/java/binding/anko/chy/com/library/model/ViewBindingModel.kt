package binding.anko.chy.com.library.model

import android.view.View
import binding.anko.chy.com.library.observable.ObservableField

class ViewBindingModel : AnkoBindingModel {
    val visible = ObservableField(true)
    var onClick = ObservableField<View.OnClickListener>()
}