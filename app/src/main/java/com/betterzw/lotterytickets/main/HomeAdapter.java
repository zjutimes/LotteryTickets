package com.betterzw.lotterytickets.main;


import com.betterzw.lotterytickets.R;
import com.betterzw.lotterytickets.api.LotteryBaseData;
import com.betterzw.lotterytickets.api.Repo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by zhengwu on 4/11/18.
 */
public class HomeAdapter extends BaseQuickAdapter<LotteryBaseData.LotteryData, BaseViewHolder> {

    public HomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, LotteryBaseData.LotteryData item) {


        helper.setText(R.id.tv_ball_1, item.codeNumber.get(0));
        helper.setText(R.id.tv_ball_2, item.codeNumber.get(1));
        helper.setText(R.id.tv_ball_3, item.codeNumber.get(2));
        helper.setText(R.id.tv_ball_4, item.codeNumber.get(3));
        helper.setText(R.id.tv_ball_5, item.codeNumber.get(4));
        helper.setText(R.id.tv_ball_6, item.codeNumber.get(5));
        helper.setText(R.id.tv_ball_7, item.codeNumber.get(6));


       /* helper.setText(R.id.titleTV, item.fullName);
        helper.setText(R.id.descriptionTV, item.description);

        helper.setText(R.id.startTV, mContext.getString(R.string.format_star, item.stars));
        helper.setText(R.id.forkTV, mContext.getString(R.string.format_fork, item.forks));
        helper.setText(R.id.languageTV, item.language);

        SimpleDraweeView draweeView = helper.getView(R.id.icon_iv);
        draweeView.setImageURI(item.owner.avatorUrl);*/

    }
}