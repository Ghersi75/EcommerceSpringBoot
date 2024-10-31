import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardImageContainer, CardTitle } from "./shadcn/card";
import { ItemData } from "@/lib/types/StoreItemTypes";
import { useState } from "react";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "./shadcn/carousel";
import { Button } from "./shadcn/button";
import Link from "next/link";

// TODO: Fix this to work with the new endpoint response

const placeholderImageLink = "https://cdn4.vectorstock.com/i/1000x1000/93/98/default-placeholder-fitness-trainer-in-a-t-shirt-vector-21189398.jpg"

export default function ItemCard({ data }: { data: ItemData }) {
  return (
    <Card className="w-[400px]">
      <CardImageContainer>
        <Carousel className="relative">
          <CarouselContent>
            <CarouselItem>
              <CardImage
                src={placeholderImageLink}
                className={`w-[400px] h-[200px] object-contain`}
              />
            </CarouselItem>
          </CarouselContent>
        </Carousel>
      </CardImageContainer>
      <CardHeader>
        <CardTitle>{data.title}</CardTitle>
        <CardDescription>{data.description}</CardDescription>
      </CardHeader>
      <CardFooter className="flex justify-end">
        <Link href={`/items/${data.id}`}>
          <Button> View More </Button>
        </Link>
      </CardFooter>
    </Card>
  );
}
