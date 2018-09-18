package binding.anko.chy.com.library.view

import android.view.View
import binding.anko.chy.com.library.R
import binding.anko.chy.com.library.dataBinding.ViewDataBinding
import binding.anko.chy.com.library.model.ViewBindingModel

fun View.bind(viewModel: ViewBindingModel) {
    var viewDataBinding = getTag(R.id.ankobinding) as? ViewDataBinding
    if (viewDataBinding == null) {
        viewDataBinding = ViewDataBinding()
        setTag(R.id.ankobinding, viewDataBinding)
    }
    viewDataBinding.bind(this, viewModel)
}

fun View.twoWayBind(viewModel: ViewBindingModel) {

}