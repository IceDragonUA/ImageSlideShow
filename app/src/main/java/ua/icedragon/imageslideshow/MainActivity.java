package ua.icedragon.imageslideshow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.icedragon.imageslideshow.model.Product;
import ua.icedragon.imageslideshow.widget.CardsSliderView;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.cards_slider_view) CardsSliderView cardsSliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initCardsSliderView();
    }

    private void initCardsSliderView() {
        List<Product> products = getStubProducts();
        cardsSliderView.bindData(products);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    private List<Product> getStubProducts() {
        List<Product> res = new ArrayList<>();
        res.add(new Product(1, "first", "http://images5.alphacoders.com/350/350374.jpg"));
        res.add(new Product(2, "second", "http://images7.alphacoders.com/421/421423.jpg"));
        res.add(new Product(3, "third", "http://images3.alphacoders.com/169/169085.jpg"));
        return res;
    }
}
