package arb.test.image.slider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() ,BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener {

    val img = listOf(
            "https://wallpaperplay.com/walls/full/c/5/3/34778.jpg" ,
            "https://wallpaperplay.com/walls/full/a/e/4/34784.jpg" ,
            "https://wallpaperplay.com/walls/full/6/8/8/294.jpg" ,
            "https://wallpaperplay.com/walls/full/9/c/8/291.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSlider()

    }

    private fun getSlider() {
        for (item in 0 until img.count()){

            val textSliderView = TextSliderView(this).apply {
                description("Test")
                image(img[item])
                setOnSliderClickListener(this@MainActivity)
                scaleType = BaseSliderView.ScaleType.FitCenterCrop
            }

            slider.addSlider(textSliderView)
        }
    }

    override fun onStop() {
        slider.stopAutoCycle()
        super.onStop()
    }

    override fun onSliderClick(slider: BaseSliderView?) {
       Toast.makeText(this,"test",Toast.LENGTH_SHORT).show()
    }

    override fun onPageScrollStateChanged(state: Int) {
        }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {

    }
}
