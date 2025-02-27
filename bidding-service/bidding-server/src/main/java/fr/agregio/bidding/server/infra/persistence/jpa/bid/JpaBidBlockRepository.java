package fr.agregio.bidding.server.infra.persistence.jpa.bid;

import fr.agregio.bidding.server.domain.bid.BidBlock;
import fr.agregio.bidding.server.infra.persistence.jpa.supply.JpaSupplyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class JpaBidBlockRepository {

    private final BidBlockDao bidBlockDao;
    private final BidBlockJpaDtoMapper bidBlockJpaDtoMapper;
    private final JpaSupplyRepository jpaSupplyRepository;

    JpaBidBlockRepository(
            BidBlockDao bidBlockDao,
            BidBlockJpaDtoMapper bidBlockJpaDtoMapper,
            JpaSupplyRepository jpaSupplyRepository) {
        this.bidBlockDao = bidBlockDao;
        this.bidBlockJpaDtoMapper = bidBlockJpaDtoMapper;
        this.jpaSupplyRepository = jpaSupplyRepository;
    }

    List<BidBlock> saveAll(String bidId, List<BidBlock> bidBlocks) {
        return bidBlocks.stream()
                .map(bidBlock -> save(bidId, bidBlock))
                .toList();
    }

    List<BidBlock> findAllByBidId(String bidId) {
        return bidBlockDao.findAllByBidId(bidId)
                .stream()
                .map(dto -> {
                    var supplies = jpaSupplyRepository.findAllByBidBlockId(dto.getId());
                    return bidBlockJpaDtoMapper.from(dto, supplies);
                })
                .toList();
    }

    private BidBlock save(String bidId, BidBlock bidBlock) {
        var toBeSaved = bidBlockJpaDtoMapper.to(bidId, bidBlock);
        var saved = bidBlockDao.save(toBeSaved);

        var supplies = jpaSupplyRepository.saveAll(saved.getId(), bidBlock.supplies());
        return bidBlockJpaDtoMapper.from(saved, supplies);
    }

}
