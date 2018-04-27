package com.betterzw.lotterytickets.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zhengwu on 4/27/18.
 */
public interface LotteryService {

    //    https://api.github.com/repos/square/retrofit/contributors
//    http://m.lottery.gov.cn/api/mlottery_kj_detail.jspx?_ltype=4&_term=18047&_num=10
    @GET("mlottery_kj_detail.jspx")
    Call<List<LotteryBaseData>> contributors(@Query("_ltype") int type,
                                             @Query("_term") String date,
                                             @Query("_num") int num);


    //    https://api.github.com/search/repositories?q=google&page=1
//    https://api.github.com/search/repositories?q=created:2008-07-04&page=1&order=stars&order=desc
//    @GET("search/repositories")
//    Call<RepoSearchResponse> searchRepos(@Query("q") String query, @Query("page") int page);


}
