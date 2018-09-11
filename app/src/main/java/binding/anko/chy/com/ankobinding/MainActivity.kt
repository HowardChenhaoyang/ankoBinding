package binding.anko.chy.com.ankobinding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import binding.anko.chy.com.library.model.ViewBindingModel
import binding.anko.chy.com.library.view.bind
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    private val viewBindingModel = ViewBindingModel().apply {
        onClick.set(View.OnClickListener {
            visible.set(!(visible.get() ?: true))
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            textView("hello") {
                textSize = 20f
                bind(viewBindingModel)
            }.lparams()
        }
    }
}
