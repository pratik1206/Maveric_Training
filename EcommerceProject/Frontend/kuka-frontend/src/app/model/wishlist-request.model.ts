// wishlist-request.model.ts

export interface WishListRequest {
    serialNo?: number; // Use a question mark to indicate optional properties
    productId: string;
    createdAt?: Date;
    userId: number;
    quantity: number;
  }
  