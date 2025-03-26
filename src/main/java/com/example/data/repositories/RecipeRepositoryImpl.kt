package com.example.data.repositories

import com.example.data.mappers.RecipeMapper
import com.example.data.retrofit.RecipeService
import com.example.domain.models.RecipeEntity
import com.example.domain.repositories.RecipeRepository
import jakarta.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeService: RecipeService,
    private val recipeMapper: RecipeMapper,

):RecipeRepository{
    override suspend fun search(
        token: String,
        page: Int,
        query: String
    ): List<RecipeEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun get(
        token: String,
        id: Int
    ): RecipeEntity {
        TODO("Not yet implemented")
    }
}