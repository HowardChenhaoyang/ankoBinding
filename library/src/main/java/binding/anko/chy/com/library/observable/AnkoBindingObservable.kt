package binding.anko.chy.com.library.observable

interface AnkoBindingObservable<T> {
    fun addPropertyChangeListener(propertyChangeListener: PropertyChangeListener<T>)
    fun removePropertyChangeListener(propertyChangeListener: PropertyChangeListener<T>)
}

interface PropertyChangeListener<in T> {
    fun onPropertyChanged(oldValue: T?, newValue: T?)
}
