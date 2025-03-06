package com.lokkie.yrapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.gms.ads.AdRequest
import com.lokkie.yrapp.databinding.ActivityMainBinding
import com.lokkie.yrapp.ui.theme.YrAppTheme


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adRequest = AdRequest.Builder()
            .setRequestAgent("android_studio:ad_template")
            .build()
        binding.adView.loadAd(adRequest)
        setFragment(BlankFragment())

    }
    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit  {
            replace(R.id.fragmentContainerView, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Red) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YrAppTheme {
        Greeting("test")
    }
}