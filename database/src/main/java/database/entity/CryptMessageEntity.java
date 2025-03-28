package database.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "crypt_messages")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter

public class CryptMessageEntity {
    @Id
    @Column(name = "sequence")
    long sequence;

    @Column(name = "product_id")
    String productId;

    @Column(name = "price")
    String price;

    @Column(name = "open_24h")
    String open24h;

    @Column(name = "volume_24h")
    String volume24h;

    @Column(name = "low_24h")
    String low24h;

    @Column(name = "high_24h")
    String high24h;

    @Column(name = "volume_30d")
    String volume30d;

    @Column(name = "best_bid")
    String bestBid;

    @Column(name = "best_bid_size")
    String bestBidSize;

    @Column(name = "best_ask")
    String bestAsk;

    @Column(name = "best_ask_size")
    String bestAskSize;

    @Column(name = "side")
    String side;

    @Column(name = "time")
    String time;

    @Column(name = "trade_id")
    long tradeId;

    @Column(name = "last_size")
    String lastSize;
}
