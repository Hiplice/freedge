package com.example.user.freedge.RecyclerViewHandlers;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.freedge.DataHandler;
import com.example.user.freedge.Fragments.NoDataFragment;
import com.example.user.freedge.MainActivity;
import com.example.user.freedge.R;

public class ProductMenuListView extends RecyclerView.Adapter<ProductMenuListView.ViewHolder> {

    private String[][] mDataList;
    private Context context;

    private FragmentTransaction transaction;
    private LinearLayout menuElementRectangle;
    private ImageView categoryIcon;
    private TextView boldProductName;
    private TextView productAddDate;
    private TextView productWeight;

    @NonNull
    @Override
    public ProductMenuListView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View recyclerViewRow = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(recyclerViewRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductMenuListView.ViewHolder viewHolder, int position) {
        boldProductName.setText(mDataList[position][1]);
        productAddDate.setText(mDataList[position][5]);
        productWeight.setText(mDataList[position][2] + " " + mDataList[position][3]);
        categoryIcon.setImageResource(DataHandler.getCategoryIconsById(mDataList[position][4]));
        menuElementRectangle.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, DataHandler.getCategoryColorsById(mDataList[position][4]))));
    }

    public ProductMenuListView(Context context, String[][] dataList) {
        mDataList = dataList; // [productID, productName, productWeight, amount, categoryID, addDate]

        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ViewHolder(View itemView) {
            super(itemView);
            menuElementRectangle = itemView.findViewById(R.id.menuElem);
            categoryIcon = itemView.findViewById(R.id.categoryImage);
            boldProductName = itemView.findViewById(R.id.boldProductName);
            productAddDate = itemView.findViewById(R.id.productAddDate);
            productWeight = itemView.findViewById(R.id.weightText);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.length;
    }
}