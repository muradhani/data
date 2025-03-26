package com.example.data.repositories

import com.example.data.mappers.RecipeMapper
import com.example.data.retrofit.RecipeService
import com.example.domain.models.RecipeEntity
import com.example.domain.repositories.RecipeRepository
import jakarta.inject.Inject
import retrofit2.Response

class RecipeRepositoryImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val recipeMapper: RecipeMapper,

):RecipeRepository{
    override suspend fun search(
        token: String,
        page: Int,
        query: String
    ): List<RecipeEntity>? {
        return handleApiResponse(recipeService.search(token, page, query)) {
            recipeMapper.dtoListToEntityList(it.recipes)
        }
    }

    override suspend fun get(
        token: String,
        id: Int
    ): RecipeEntity? {
        return handleApiResponse(recipeService.get(token, id)) {
            recipeMapper.dtoToEntity(it)
        }
    }

    private inline fun <T, R> handleApiResponse(
        response: Response<T>,
        transform: (T) -> R
    ): R? {
        return if (response.isSuccessful) {
            response.body()?.let { transform(it) }
        } else {
            null
        }
    }
}