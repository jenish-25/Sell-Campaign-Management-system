package sale_campaign.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import sale_campaign.Model.PriceHistory;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class PriceHistoryRepoImpl implements PriceHistoryRepository{

    @Override
    public List<PriceHistory> findAllByProductId(String productId) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PriceHistory> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PriceHistory> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PriceHistory> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PriceHistory getOne(Integer integer) {
        return null;
    }

    @Override
    public PriceHistory getById(Integer integer) {
        return null;
    }

    @Override
    public PriceHistory getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends PriceHistory> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PriceHistory> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PriceHistory> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PriceHistory> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PriceHistory> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PriceHistory> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PriceHistory, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PriceHistory> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PriceHistory> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PriceHistory> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<PriceHistory> findAll() {
        return null;
    }

    @Override
    public List<PriceHistory> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(PriceHistory entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends PriceHistory> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<PriceHistory> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PriceHistory> findAll(Pageable pageable) {
        return null;
    }
}
