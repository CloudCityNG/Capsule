package com.pitchedapps.capsule.library.item;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.mikepenz.iconics.typeface.IIcon;
import com.pitchedapps.capsule.library.interfaces.CDrawerItem;

/**
 * Created by Allan Wang on 2016-10-30.
 */

public class DrawerItem implements CDrawerItem {

    private Fragment mFragment;
    private int mTitleId;
    private IIcon mIcon;
    private boolean mIsPrimary;
    public static final int DIVIDER = -1;

    public DrawerItem(int type) {
        mTitleId = type;
    }

    public DrawerItem(Fragment fragment, @StringRes int titleId, IIcon icon, boolean isPrimary) {
        mFragment = fragment;
        mTitleId = titleId;
        mIcon = icon;
        mIsPrimary = isPrimary;
    }

    @Nullable
    @Override
    public Fragment getFragment() {
        return mFragment;
    }

    @Override
    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    @Override
    public int getTitleId() {
        return mTitleId;
    }

    @Override
    public IIcon getIcon() {
        return mIcon;
    }

    @Override
    public boolean isPrimary() {
        return mIsPrimary;
    }
}
