package com.madhan.listdemo

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.madhan.listdemo.ui.MainActivity
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    public var rule =
        ActivityTestRule(MainActivity::class.java)
    private val context: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext
    @Test
    @Throws(Exception::class)
    fun ensureListViewIsPresent() {
        val activity = rule.activity
        val viewById = activity.findViewById<View>(R.id.rvListView)
        MatcherAssert.assertThat(viewById, Matchers.notNullValue())
        MatcherAssert.assertThat(
            viewById, Matchers.instanceOf<Any>(
                RecyclerView::class.java
            )
        )
        val listView = viewById as RecyclerView
        val adapter = listView.adapter
        MatcherAssert.assertThat(
            adapter, Matchers.instanceOf<Any?>(
                RecyclerView.Adapter::class.java
            )
        )
        MatcherAssert.assertThat(adapter!!.itemCount, Matchers.greaterThan(5))
    }
}