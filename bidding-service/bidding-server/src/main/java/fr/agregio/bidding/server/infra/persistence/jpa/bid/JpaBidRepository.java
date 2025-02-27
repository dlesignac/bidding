package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import fr.agregio.bidding.server.domain.bid.Bid;
import fr.agregio.bidding.server.domain.bid.BidRepository;
import fr.agregio.bidding.server.domain.market.MarketId;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
class JpaBidRepository
        implements BidRepository {

    private final BidDao bidDao;
    private final BidJpaDtoMapper bidJpaDtoMapper;
    private final JpaBidBlockRepository jpaBidBlockRepository;

    JpaBidRepository(
            BidDao bidDao,
            BidJpaDtoMapper bidJpaDtoMapper,
            JpaBidBlockRepository jpaBidBlockRepository) {
        this.bidDao = bidDao;
        this.bidJpaDtoMapper = bidJpaDtoMapper;
        this.jpaBidBlockRepository = jpaBidBlockRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bid> findAll() {
        var dtos = bidDao.findAll();
        return complete(dtos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bid> findAll(MarketId marketId) {
        var dtos = bidDao.findAllByMarketId(marketId.value());
        return complete(dtos);
    }

    @Override
    @Transactional
    public Bid create(Bid bid) {
        var toBeSaved = bidJpaDtoMapper.to(bid);
        var saved = bidDao.save(toBeSaved);
        var blocks = jpaBidBlockRepository.saveAll(saved.getId(), bid.blocks());
        return bidJpaDtoMapper.from(saved, blocks);
    }

    private Bid complete(BidJpaDto dto) {
        var blocks = jpaBidBlockRepository.findAllByBidId(dto.getId());
        return bidJpaDtoMapper.from(dto, blocks);
    }

    private List<Bid> complete(List<BidJpaDto> dtos) {
        return dtos.stream()
                .map(this::complete)
                .toList();
    }

}
