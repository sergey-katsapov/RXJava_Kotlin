package jellgo_bytes.rxjavasimple.data;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jellgo_bytes.rxjavasimple.R;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder> {

    private final Context mContext;
    private final List<String> mStrings = new ArrayList<>();

    public StringAdapter(Context context) {
        mContext = context;
    }

    public void setStrings(List<String> newStrings) {
        mStrings.clear();
        mStrings.addAll(newStrings);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.string_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.personsTextView.setText(mStrings.get(position));
        holder.itemView.setOnClickListener(v -> Toast.makeText(mContext, mStrings.get(position), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView personsTextView;
        ViewHolder(View view) {
            super(view);
            personsTextView = view.findViewById(R.id.persons_display);
        }
    }
}
