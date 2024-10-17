"use client"

import { CardImage } from "@/components/shadcn/card"
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "@/components/shadcn/carousel"
import useFetchItemById from "@/lib/hooks/useFetchItemById"

const testImages = [
  "https://img.freepik.com/free-psd/stylish-blue-plaid-shirt-men-isolated-transparent-background_191095-23042.jpg?w=1380&t=st=1729206787~exp=1729207387~hmac=46e94f52ac1b8c57aceaa42fd1ff16798515d69aa26c44d83ce8c78d5703c645",
  "https://media.gettyimages.com/id/471188329/photo/plain-red-tee-shirt-isolated-on-white-background.jpg?s=612x612&w=gi&k=20&c=RGOHoV-pQqfvG3gMgKpa4PNbV5gUJPY3SniV1ao9yGM="
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
      <div className="bg-blue-500 w-2/3 p-12 flex justify-center">
        <div className="w-2/3 h-full bg-red-500">
          <Carousel className="relative">
            <CarouselContent>
            {testImages.map((item, idx) => {
              return (
                <CarouselItem>
                  <CardImage src={item} key={idx} className="rounded-xl"/>
                </CarouselItem>
              )
            })}
            </CarouselContent>
            <CarouselNext className="absolute right-12" />
            <CarouselPrevious className="absolute left-12" />
          </Carousel>
        </div>
      </div>
      <div className="bg-green-500 w-1/3 p-4"> Modifiers and other stuff </div>
    </div>
  )
}