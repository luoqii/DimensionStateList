package org.bbs.android.dimensionstatelist;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    // public for test only.
    public boolean mPaused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        mPaused = false;
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        mPaused = true;
    }

    public static class MyButton extends Button {


        private DimensionStateList mTextSize;

        public MyButton(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            // TODO Auto-generated constructor stub
        }

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);

            try {
                mTextSize = DimensionStateList.createFromXml(getResources(),
                        getResources().getXml(R.xml.button_text_size));
            } catch (Resources.NotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ;
        }

        public MyButton(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        @Override
        protected void drawableStateChanged() {
            super.drawableStateChanged();

            int size = mTextSize.getColorForState(getDrawableState(), 50);

            setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        }

    }
}
