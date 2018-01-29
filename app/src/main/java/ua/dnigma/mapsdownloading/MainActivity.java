package ua.dnigma.mapsdownloading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ua.dnigma.mapsdownloading.xml_parsing.RegionsXmlParsing;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new RegionsXmlParsing().xmlParsingToPojoModel(this);
    }
}
