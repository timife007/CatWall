import com.example.catwall.common.data.api.model.ApiBreed
import com.example.catwall.common.data.api.model.ApiCatBreeds
import com.example.catwall.utils.Result
import kotlinx.coroutines.flow.Flow


interface CatRemoteDataSource {
    fun getCats(): Flow<Result<List<ApiBreed>>>
}