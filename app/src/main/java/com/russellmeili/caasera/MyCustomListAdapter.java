package com.russellmeili.caasera;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;

import android.widget.TextView;

/**
 * Created by russm on 3/16/2017.
 */

public class MyCustomListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Group_heading> deptList;

    public MyCustomListAdapter(Context context, ArrayList<Group_heading> deptList) {
        this.context = context;
        this.deptList = deptList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child_row> productList =
                deptList.get(groupPosition).getProductList();
        return productList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        Child_row child_row = (Child_row) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.child_row, null);
        }

        TextView sequence = (TextView) view.findViewById(R.id.sequence);
        sequence.setText(child_row.getSequence().trim() + ") ");
        TextView childItem = (TextView) view.findViewById(R.id.childItem);
        childItem.setText(child_row.getName().trim());

        return view;
    }


    @Override
    public int getChildrenCount(int groupPosition) {

        ArrayList<Child_row> productList =
                deptList.get(groupPosition).getProductList();
        return productList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return deptList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return deptList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        Group_heading group_heading = (Group_heading) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.activity_group_heading, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.heading);
        heading.setText(group_heading.getName().trim());

        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
