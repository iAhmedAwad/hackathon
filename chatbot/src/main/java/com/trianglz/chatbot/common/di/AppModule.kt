package com.trianglz.chatbot.common.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //region Network
    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun provideHttpClient(
        builder: OkHttpClient.Builder,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("156.194.48.168",8888))

        return   builder.addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(httpLoggingInterceptor)
           //.proxy(proxy)
            .callTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //    @Singleton
    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        builder: Retrofit.Builder,
        moshi: Moshi,
        //baseUrl: String = BASEURL
    ): Retrofit =
        builder
            .baseUrl(BASEURL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient)
            .build()
    //endregion


    companion object {
        const val BASEURL = "https://4e9d-156-194-48-168.ngrok-free.app/"
    }
}