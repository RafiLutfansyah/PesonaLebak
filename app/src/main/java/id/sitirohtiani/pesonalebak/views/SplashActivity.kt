package id.sitirohtiani.pesonalebak.views

import android.content.Intent
import com.daimajia.androidanimations.library.Techniques
import com.viksaa.sssplash.lib.activity.AwesomeSplash
import com.viksaa.sssplash.lib.cnst.Flags
import com.viksaa.sssplash.lib.model.ConfigSplash
import id.sitirohtiani.pesonalebak.R
import id.sitirohtiani.pesonalebak.views.main.MainActivity

/**
 * Created by Rafi Lutfansyah on 02/03/2018.
 */

//extends AwesomeSplash!
class SplashActivity : AwesomeSplash() {

    //DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!
    override fun initSplash(configSplash: ConfigSplash) {
        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.backgroundColor = R.color.colorAccent //any color you want form colors.xml
        configSplash.animCircularRevealDuration = 300 //int ms
        configSplash.revealFlagX = Flags.REVEAL_RIGHT  //or Flags.REVEAL_LEFT
        configSplash.revealFlagY = Flags.REVEAL_BOTTOM //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.logoSplash = R.drawable.logo_pl //or any other drawable
        configSplash.animLogoSplashDuration = 300 //int ms
        configSplash.animLogoSplashTechnique = Techniques.Bounce //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        /*
        //Customize Path
        //configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.secondaryColor); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.fillColor); //path object filling color
        */

        //Customize Title
        configSplash.titleSplash = "Pesona Lebak"
        configSplash.titleTextColor = R.color.colorPrimary
        configSplash.titleTextSize = 30f //float value
        configSplash.animTitleDuration = 300
        configSplash.animTitleTechnique = Techniques.FlipInX
        //configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/
    }

    override fun animationsFinished() {
        //transit to another activity here
        //or do whatever you want
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
