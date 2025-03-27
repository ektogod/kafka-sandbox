package consumer.dto;

public record Message(String title,
                      String description,
                      String senderName,
                      int senderAge) {
}
