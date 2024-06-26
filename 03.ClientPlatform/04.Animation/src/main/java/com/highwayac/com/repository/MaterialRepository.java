package com.highwayac.com.repository;

import com.highwayac.com.domain.Material;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Material entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MaterialRepository extends ReactiveCrudRepository<Material, Long>, MaterialRepositoryInternal {
    @Query("SELECT * FROM material entity WHERE entity.extra_info_id = :id")
    Flux<Material> findByExtraInfo(Long id);

    @Query("SELECT * FROM material entity WHERE entity.extra_info_id IS NULL")
    Flux<Material> findAllWhereExtraInfoIsNull();

    @Query("SELECT * FROM material entity WHERE entity.workspace_id = :id")
    Flux<Material> findByWorkspace(Long id);

    @Query("SELECT * FROM material entity WHERE entity.workspace_id IS NULL")
    Flux<Material> findAllWhereWorkspaceIsNull();

    @Override
    <S extends Material> Mono<S> save(S entity);

    @Override
    Flux<Material> findAll();

    @Override
    Mono<Material> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface MaterialRepositoryInternal {
    <S extends Material> Mono<S> save(S entity);

    Flux<Material> findAllBy(Pageable pageable);

    Flux<Material> findAll();

    Mono<Material> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Material> findAllBy(Pageable pageable, Criteria criteria);
}
