package com.example.catwall.common.data.di

import com.example.catwall.common.data.api.ApiConstants
import com.example.catwall.common.data.api.CatWallApi
import com.example.catwall.common.data.api.interceptors.AuthenticationInterceptor
import com.example.catwall.common.data.api.interceptors.LoggingInterceptor
import com.example.catwall.common.data.api.interceptors.NetworkStatusInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): CatWallApi {
        return builder.build().create(CatWallApi::class.java)
    }
    @Provides
    fun provideGson():Gson=Gson()

    @Provides
    fun provideGsonConverter(gson:Gson):GsonConverterFactory{
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL).client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
    }

    @Provides
    fun provideOkHttpClient(
        networkStatusInterceptor: NetworkStatusInterceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        authenticationInterceptor: AuthenticationInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkStatusInterceptor)
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(loggingInterceptor)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


}