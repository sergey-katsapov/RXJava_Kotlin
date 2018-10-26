package jellgo_bytes.rxjavasimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jellgo_bytes.rxjavasimple.data.RestClient;
import jellgo_bytes.rxjavasimple.data.StringAdapter;


public class MainActivity extends AppCompatActivity {

    private Disposable perosonSubscription;
    private RecyclerView personsRecyclerView;
    private ProgressBar progressBar;
    private RestClient restClient;
    private StringAdapter stringAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restClient = new RestClient(this);
        configureLayout();
        createObservable();
    }

    private void createObservable() {
        io.reactivex.Observable<List<String>> personsObservable =
                io.reactivex.Observable.fromCallable(() -> restClient.getPersons());
                perosonSubscription = personsObservable.
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::displayPersons);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (perosonSubscription != null && !perosonSubscription.isDisposed()) {
            perosonSubscription.dispose();
        }
    }

    private void displayPersons(List<String> persons) {
        stringAdapter.setStrings(persons);
        progressBar.setVisibility(View.GONE);
        personsRecyclerView.setVisibility(View.VISIBLE);
    }


    private void configureLayout() {
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.loader);
        personsRecyclerView = findViewById(R.id.person_name_list);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stringAdapter = new StringAdapter(this);
        personsRecyclerView.setAdapter(stringAdapter);
    }
}
