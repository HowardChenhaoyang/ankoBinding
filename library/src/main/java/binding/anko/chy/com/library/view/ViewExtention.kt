package binding.anko.chy.com.library.view

import android.view.View
import binding.anko.chy.com.library.dataBinding.ViewDataBinding
import binding.anko.chy.com.library.model.ViewBindingModel

fun View.bind(viewModel: ViewBindingModel) {
    ViewDataBinding().bind(this, viewModel)
}

fun View.twoWayBind(viewModel: ViewBindingModel) {

}