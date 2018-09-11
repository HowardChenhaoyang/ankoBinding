package binding.anko.chy.com.library.dataBinding

import android.view.View
import binding.anko.chy.com.library.model.ViewBindingModel
import binding.anko.chy.com.library.observable.PropertyChangeListener

class ViewDataBinding : AnkoDataBinding<View, ViewBindingModel> {

    override fun bind(view: View, viewBindingModel: ViewBindingModel) {
        viewBindingModel.visible.addPropertyChangeListener(object : PropertyChangeListener<Boolean> {
            override fun onPropertyChanged(oldValue: Boolean?, newValue: Boolean?) {
                view.visibility = if (newValue == true) View.VISIBLE else View.GONE
            }
        })
        viewBindingModel.onClick.addPropertyChangeListener(object : PropertyChangeListener<View.OnClickListener> {
            override fun onPropertyChanged(oldValue: View.OnClickListener?, newValue: View.OnClickListener?) {
                view.setOnClickListener(newValue)
            }
        })
        viewBindingModel.visible.notifyPropertyChange()
        viewBindingModel.onClick.notifyPropertyChange()
    }

    override fun twoWayBind(v: View, m: ViewBindingModel) {
    }
}