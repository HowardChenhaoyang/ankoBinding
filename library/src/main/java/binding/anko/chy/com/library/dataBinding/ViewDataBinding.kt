package binding.anko.chy.com.library.dataBinding

import android.view.View
import binding.anko.chy.com.library.model.ViewBindingModel

class ViewDataBinding : AnkoDataBinding<View, ViewBindingModel>() {


    override fun realBind(view: View, viewBindingModel: ViewBindingModel) {
        with(viewBindingModel) {
            visible.propertyChange { _, newValue ->
                view.visibility = if (newValue == true) View.VISIBLE else View.GONE
            }

            onClick.propertyChange { _, newValue ->
                view.setOnClickListener(newValue)
            }
        }
    }

    override fun realTwoWayBind(v: View, m: ViewBindingModel) {
    }
}