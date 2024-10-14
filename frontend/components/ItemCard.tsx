import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardImageContainer, CardTitle } from "./shadcn/card";
import { Data } from "@/app/page";
import { useState } from "react";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "./shadcn/carousel";

const placeholderImageLink = "https://cdn4.vectorstock.com/i/1000x1000/93/98/default-placeholder-fitness-trainer-in-a-t-shirt-vector-21189398.jpg"

export default function ItemCard({ data }: { data: Data }) {
  return (
    <Card className="w-[400px]">
      <CardImageContainer>
        <Carousel className="relative">
          <CarouselContent>
            {
              data.images.length == 0 &&
              <CarouselItem>
                <CardImage
                  src={placeholderImageLink}
                  className={`w-[400px] h-[200px] object-contain`}
                />
              </CarouselItem>
            }
            {data.images.map((item, idx) => {
              return (
                <CarouselItem key={idx}>
                  <CardImage
                    src={item.imageLink}
                    className={`w-[400px] h-[200px] object-contain`}
                  />
                </CarouselItem>
              )
            })}
          </CarouselContent>
          {
            data.images.length > 1 &&
            <>
              <CarouselPrevious className="absolute left-4"/>
              <CarouselNext className="absolute right-4" />
            </>
          }
        </Carousel>
      </CardImageContainer>
      <CardHeader>
        <CardTitle>{data.title}</CardTitle>
        <CardDescription>{data.description}</CardDescription>
      </CardHeader>
      <CardFooter>
        <p>Buy Now</p>
      </CardFooter>
    </Card>
  );
}
