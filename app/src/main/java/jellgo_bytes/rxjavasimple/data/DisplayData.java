package jellgo_bytes.rxjavasimple.data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class DisplayData {

    public StringAdapter stringAdapter;
    public ProgressBar progressBar;
    public RecyclerView recyclerView;

    public  void displayData(List<String> T) {
        stringAdapter.setStrings(T);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
