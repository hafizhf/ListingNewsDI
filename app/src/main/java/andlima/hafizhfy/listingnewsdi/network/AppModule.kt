package andlima.hafizhfy.listingnewsdi.network

import andlima.hafizhfy.listingnewsdi.News
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun instance() : News {
        return News()
    }
}