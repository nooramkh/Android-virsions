package com.nooraabumakhada.androidversions;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class AndroidVersionAdapter extends RecyclerView.Adapter<AndroidVersionAdapter.VersionViewHolder> {

    private final LinkedList<AndroidVersion> mVersionList;
    private LayoutInflater mInflater;
    private Context mContext;

    public AndroidVersionAdapter(Context context, LinkedList<AndroidVersion> versionList) {
        mInflater = LayoutInflater.from(context);
        this.mVersionList = versionList;
        this.mContext = context;
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_android_version, parent, false);
        return new VersionViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(VersionViewHolder holder, int position) {
        AndroidVersion mCurrent = mVersionList.get(position);

        holder.tvCodeName.setText(mCurrent.getCodeName());
        holder.tvVersion.setText(mCurrent.getVersion());
        holder.imgLogo.setImageResource(mCurrent.getImageResId());

        CardView cardView = (CardView) holder.itemView;

        if (position % 2 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#E0E0E0"));
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

    @Override
    public int getItemCount() {
        return mVersionList.size();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView tvCodeName;
        public final TextView tvVersion;
        public final ImageView imgLogo;
        final AndroidVersionAdapter mAdapter;

        public VersionViewHolder(View itemView, AndroidVersionAdapter adapter) {
            super(itemView);
            tvCodeName = itemView.findViewById(R.id.tvCodeName);
            tvVersion = itemView.findViewById(R.id.tvVersion);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            this.mAdapter = adapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            AndroidVersion element = mVersionList.get(mPosition);

            String message = "You selected: " + element.getCodeName() + " (" + element.getVersion() + ")";
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        }
    }
}