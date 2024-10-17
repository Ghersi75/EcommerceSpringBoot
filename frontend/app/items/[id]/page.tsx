"use client"

import { CardImage } from "@/components/shadcn/card"
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "@/components/shadcn/carousel"
import useFetchItemById from "@/lib/hooks/useFetchItemById"

const testImages = [
  "https://img.freepik.com/premium-photo/man-wearing-shirt-that-says-he-is-wearing-shirt_1313274-13659.jpg?w=1380",
  "https://img.freepik.com/free-photo/shirt_1203-8194.jpg?w=1800&t=st=1729207891~exp=1729208491~hmac=a591c163f01c9e0e45c88112ea1f33741f5eb040c01bd30ce8a0b871ca15e553",
  "https://img.freepik.com/premium-photo/blue-plaid-shirt-with-white-collar-blue-jeans_1086760-50674.jpg?w=2000",
  "https://img.freepik.com/free-psd/stylish-blue-plaid-shirt-men-isolated-transparent-background_191095-23042.jpg?w=1380&t=st=1729206787~exp=1729207387~hmac=46e94f52ac1b8c57aceaa42fd1ff16798515d69aa26c44d83ce8c78d5703c645",
  "https://media.gettyimages.com/id/471188329/photo/plain-red-tee-shirt-isolated-on-white-background.jpg?s=612x612&w=gi&k=20&c=RGOHoV-pQqfvG3gMgKpa4PNbV5gUJPY3SniV1ao9yGM=",
  "https://img.freepik.com/premium-photo/man-wearing-plaid-shirt-stands-front-window_1313274-13213.jpg?w=1380",
  "https://img.freepik.com/premium-photo/man-wear-white-short-sleeve-button-down-mockup_1290684-1661.jpg?w=1380"
]

export default function ViewItem({ params }: { params: { id: number } }) {
  const { data, isLoading, error } = useFetchItemById(params.id)

  if (error) {
    // TODO add actual error handling logic
    console.log(error)
  }

  if (isLoading) {
    return (<div> loading </div>)
  }

  // Not laoding and no data, something went wrong
  // TODO: Figure out what to do when no data loads for whatever reason. Probably linked to the if (error)
  if (!data) {
    return (<div> whoopsie daisy</div>)
  }

  // No need to worry about data being empty and having a bunch of ????????????????? here
  // Figure out design later, im no designer
  return (
    <div className="flex flex-1 flex-row h-full w-3/4">
      <div className="container bg-blue-500 w-2/3 p-8 columns-3">
        {testImages.map((item, idx) => {
          return (
            <div className="h-fit p-4">
              <img src={item} />
            </div>
          )
        })}
      </div>
      <div className="bg-green-500 w-1/3 p-4"> Modifiers and other stuff </div>
    </div>
  )
}