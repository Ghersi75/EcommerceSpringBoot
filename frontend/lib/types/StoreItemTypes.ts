export interface StoreItemData {
  id: string,
  title: string,
  description: string,
  displayOrder: number,
  price: number,
  discountPrice: number | null,
  thumbnailImageLink: string
}