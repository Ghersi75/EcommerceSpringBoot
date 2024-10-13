import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardImage, CardTitle } from "./shadcn/card";
import { Data } from "@/app/page";

export default function ItemCard({ data }: { data: Data }) {
  return (
    <Card className="w-[400px]">
      <CardImage src={data.imageLink} className="w-[400px] h-[200px] object-contain">

      </CardImage>
      <CardHeader>
        <CardTitle> {data.title} </CardTitle>
        <CardDescription> {data.description} </CardDescription>
      </CardHeader>
      <CardFooter>
        <p>
          Buy Now
        </p>
      </CardFooter>
    </Card>
  )
}